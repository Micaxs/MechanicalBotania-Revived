package net.micaxs.mechanicalbotania.init;

import net.micaxs.mechanicalbotania.MechanicalBotania;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MechanicalBotania.MODID);


    public static final RegistryObject<CreativeModeTab> SMOKELEAF_INDUSTRY_TAB = CREATIVE_MODE_TABS.register("mechanicalbotania_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemRegistry.SPINERETTE_ITEM.get()))
                    .title(Component.translatable("creativetab.mechanicalbotania_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ItemRegistry.SPINERETTE_ITEM.get());
                        pOutput.accept(ItemRegistry.SPINERETTE_FLOATING_ITEM.get());
                        pOutput.accept(ItemRegistry.MANA_MOTOR_ITEM.get());
                    }).build());


    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
