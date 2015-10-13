package powercrystals.minefactoryreloaded.api;

import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Defines a harvestable block for the Harvester.
 *
 * @author PowerCrystals
 */
public interface IFactoryHarvestable {

	/**
	 * @return The block this harvestable instance is managing.
	 */
	public Block getPlant();

	/**
	 * @return The type of harvest the Harvester should perform on this block.
	 */
	public HarvestType getHarvestType();

	/**
	 * Used to determine if the harvester should replace this block with air.
	 *
	 * @return Whether or not the Harvester should break the block when
	 *         harvesting. If false, no changes will be performed by the
	 *         Harvester itself.
	 */
	public boolean breakBlock();

	/**
	 * Used to determine if this crop can be harvested (is it at a stage that
	 * drops crops, etc.)
	 *
	 * @param world
	 *            The world this block is in.
	 * @param harvesterSettings
	 *            The harvester's current settings. Do not modify these.
	 * @param x
	 *            The X coordinate of the block being harvested.
	 * @param y
	 *            The Y coordinate of the block being harvested.
	 * @param z
	 *            The Z coordinate of the block being harvested.
	 *
	 * @return True if this block can be harvested.
	 */
	public boolean canBeHarvested(World world, Map<String, Boolean> harvesterSettings, int x, int y, int z);

	/**
	 * @param world
	 *            The world this block is in.
	 * @param rand
	 *            A Random instance to use when generating drops.
	 * @param harvesterSettings
	 *            The harvester's current settings. Do not modify these.
	 * @param x
	 *            The X coordinate of the block being harvested.
	 * @param y
	 *            The Y coordinate of the block being harvested.
	 * @param z
	 *            The Z coordinate of the block being harvested.
	 *
	 * @return The drops generated by breaking this block. For a default
	 *         implementation, calling Block.getDrops() is usually
	 *         sufficient.
	 */
	public List<ItemStack> getDrops(World world, Random rand, Map<String, Boolean> harvesterSettings, int x, int y, int z);

	/**
	 * Called before the block is going to be harvested, after getDrops. Usually
	 * empty.
	 *
	 * @param world
	 *            The world this block is in.
	 * @param x
	 *            The X coordinate of the block being harvested.
	 * @param y
	 *            The Y coordinate of the block being harvested.
	 * @param z
	 *            The Z coordinate of the block being harvested.
	 */
	public void preHarvest(World world, int x, int y, int z);

	/**
	 * Called after the block is going to be harvested. Used to re-till soil,
	 * for example.
	 *
	 * @param world
	 *            The world this block is in.
	 * @param x
	 *            The X coordinate of the block being harvested.
	 * @param y
	 *            The Y coordinate of the block being harvested.
	 * @param z
	 *            The Z coordinate of the block being harvested.
	 */
	public void postHarvest(World world, int x, int y, int z);

}
