package net.micaxs.mechanicalbotania.init;

import net.micaxs.mechanicalbotania.MechanicalBotania;
import net.micaxs.mechanicalbotania.blocks.ManaMotor;
import net.micaxs.mechanicalbotania.flowers.SpineretteFloatingFlowerBlock;
import net.micaxs.mechanicalbotania.flowers.SpineretteFlowerBlock;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vazkii.botania.common.block.BotaniaBlocks;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MechanicalBotania.MODID);
    public static final RegistryObject<ManaMotor> MANAMOTOR = BLOCKS.register("mana_motor", () -> new ManaMotor(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<SpineretteFlowerBlock> spinerette= BLOCKS.register("spinerette", () -> new SpineretteFlowerBlock(MobEffects.MOVEMENT_SPEED, 100, BlockBehaviour.Properties.copy(Blocks.POPPY), BlockEntityRegistry.SPINERETTE::get));
    public static final RegistryObject<SpineretteFloatingFlowerBlock> spineretteFloating = BLOCKS.register("spinerette_floating", () -> new SpineretteFloatingFlowerBlock(BotaniaBlocks.FLOATING_PROPS, BlockEntityRegistry.SPINERETTE::get));


}
