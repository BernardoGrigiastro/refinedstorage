package com.raoulvdberge.refinedstorage.inventory.item;

import com.raoulvdberge.refinedstorage.RSItems;
import com.raoulvdberge.refinedstorage.api.network.grid.IGridTab;
import com.raoulvdberge.refinedstorage.api.util.IFilter;
import com.raoulvdberge.refinedstorage.gui.GuiBase;
import com.raoulvdberge.refinedstorage.gui.grid.GuiGrid;
import com.raoulvdberge.refinedstorage.inventory.item.validator.ItemValidatorBasic;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.thread.EffectiveSide;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class ItemHandlerFilter extends ItemHandlerBase {
    private List<IFilter> filters;
    private List<IGridTab> tabs;

    public ItemHandlerFilter(List<IFilter> filters, List<IGridTab> tabs, @Nullable Consumer<Integer> listener) {
        super(4, listener, new ItemValidatorBasic(RSItems.FILTER));

        this.filters = filters;
        this.tabs = tabs;
    }

    @Override
    protected void onContentsChanged(int slot) {
        super.onContentsChanged(slot);

        filters.clear();
        tabs.clear();

        for (int i = 0; i < getSlots(); ++i) {
            ItemStack filter = getStackInSlot(i);

            if (!filter.isEmpty()) {
                addFilter(filter);
            }
        }

        if (EffectiveSide.get() == LogicalSide.CLIENT) { // TODO check
            GuiBase.executeLater(GuiGrid.class, grid -> grid.getView().sort());
        }
    }

    private void addFilter(ItemStack filter) {
        /* TODO int compare = ItemFilter.getCompare(filter);
        int mode = ItemFilter.getMode(filter);
        boolean modFilter = ItemFilter.isModFilter(filter);

        List<IFilter> filters = new ArrayList<>();

        ItemHandlerFilterItems items = new ItemHandlerFilterItems(filter);

        for (ItemStack stack : items.getFilteredItems()) {
            if (stack.getItem() == RSItems.FILTER) {
                addFilter(stack);
            } else if (!stack.isEmpty()) {
                filters.add(new FilterItem(stack, compare, mode, modFilter));
            }
        }

        FluidInventoryFilter fluids = new FluidInventoryFilter(filter);

        for (FluidStack stack : fluids.getFilteredFluids()) {
            filters.add(new FilterFluid(stack, compare, mode, modFilter));
        }

        ItemStack icon = ItemFilter.getIcon(filter);
        FluidStack fluidIcon = ItemFilter.getFluidIcon(filter);

        if (icon.isEmpty() && fluidIcon == null) {
            this.filters.addAll(filters);
        } else {
            tabs.add(new GridTab(filters, ItemFilter.getName(filter), icon, fluidIcon));
        }*/
    }
}
