package com.raoulvdberge.refinedstorage.item;

import com.raoulvdberge.refinedstorage.RS;
import com.raoulvdberge.refinedstorage.item.info.IItemInfo;
import com.raoulvdberge.refinedstorage.item.info.ItemInfo;

public class ItemCover extends ItemBase {
    private static final String NBT_ITEM = "Item";

    // public static final ItemStack HIDDEN_COVER_ALTERNATIVE = new ItemStack(Blocks.STONEBRICK);

    public ItemCover(IItemInfo info) {
        super(info);

        //setCreativeTab(RS.INSTANCE.coversTab);
    }

    public ItemCover() {
        this(new ItemInfo(RS.ID, "cover"));
    }

    /*
    @Override
    @SideOnly(Side.CLIENT)
    public void registerModels(IModelRegistration modelRegistration) {
        modelRegistration.setModel(this, 0, new ModelResourceLocation(info.getId(), "inventory"));

        modelRegistration.addModelLoader(() -> new CustomModelLoaderCover()); // Don't use a method reference here, it crashes the server!
    }

    public static void setItem(ItemStack cover, ItemStack item) {
        if (!cover.hasTagCompound()) {
            cover.setTagCompound(new CompoundNBT());
        }

        cover.getTagCompound().put(NBT_ITEM, item.serializeNBT());
    }

    @Nonnull
    public static ItemStack getItem(ItemStack cover) {
        if (!cover.hasTagCompound() || !cover.getTagCompound().hasKey(NBT_ITEM)) {
            return ItemStack.EMPTY;
        }

        return new ItemStack(cover.getTagCompound().getCompound(NBT_ITEM));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);

        ItemStack item = getItem(stack);

        if (!item.isEmpty()) {
            tooltip.add(item.getItem().getItemStackDisplayName(item));
        }
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (!isInCreativeTab(tab)) {
            return;
        }

        if (RS.INSTANCE.config.hideCovers) {
            ItemStack stack = new ItemStack(this);

            setItem(stack, HIDDEN_COVER_ALTERNATIVE);

            items.add(stack);

            return;
        }

        for (Block block : Block.REGISTRY) {
            Item item = Item.getItemFromBlock(block);

            if (item == Items.AIR) {
                continue;
            }

            NonNullList<ItemStack> subBlocks = NonNullList.create();

            block.getSubBlocks(CreativeTabs.SEARCH, subBlocks);

            for (ItemStack subBlock : subBlocks) {
                if (CoverManager.isValidCover(subBlock)) {
                    ItemStack stack = new ItemStack(this);

                    setItem(stack, subBlock);

                    items.add(stack);
                }
            }
        }
    }

    @Override
    public EnumActionResult onItemUse(PlayerEntity player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);

        TileEntity tile = world.getTileEntity(pos);

        // Support placing on the bottom side without too much hassle.
        if (!canPlaceOn(tile)) {
            pos = pos.up();

            facing = EnumFacing.DOWN;

            tile = world.getTileEntity(pos);
        }

        if (canPlaceOn(tile)) {
            if (world.isRemote) {
                return EnumActionResult.SUCCESS;
            }

            INetworkNode node = ((TileNode) tile).getNode();

            if (node.getNetwork() != null && !node.getNetwork().getSecurityManager().hasPermission(Permission.BUILD, player)) {
                WorldUtils.sendNoPermissionMessage(player);

                return EnumActionResult.FAIL;
            }

            if (((ICoverable) node).getCoverManager().setCover(facing, createCover(getItem(stack)))) {
                player.getHeldItem(hand).shrink(1);

                WorldUtils.updateBlock(world, pos);

                return EnumActionResult.SUCCESS;
            }

            return EnumActionResult.FAIL;
        }

        return EnumActionResult.PASS;
    }

    private boolean canPlaceOn(TileEntity tile) {
        return tile instanceof TileNode && ((TileNode) tile).getNode() instanceof ICoverable;
    }

    protected Cover createCover(ItemStack stack) {
        return new Cover(stack, CoverType.NORMAL);
    }*/
}
