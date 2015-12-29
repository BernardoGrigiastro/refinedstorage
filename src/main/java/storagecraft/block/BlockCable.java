package storagecraft.block;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import storagecraft.tile.TileCable;

import java.util.List;

public class BlockCable extends BlockBase
{
	public static final PropertyBool SENSITIVE = PropertyBool.create("sensitive");

	public BlockCable()
	{
		super("cable");
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[]
			{
				DIRECTION,
				SENSITIVE
			});
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return getDefaultState().withProperty(SENSITIVE, meta == 1);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((Boolean) state.getValue(SENSITIVE)) ? 1 : 0;
	}

	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		return new TileCable();
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List subItems)
	{
		for (int i = 0; i < 2; i++)
		{
			subItems.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
}
