package br.com.leozin.modz.projetomodmine;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Projetomodmine.MODID);

    public static final Supplier<CreativeModeTab> TUNGSTEN_TAB = CREATIVE_MODE_TABS.register("tungsten_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.TUNGSTEN_INGOT.get()))
                    .title(Component.translatable("creativetab.projetomodmine.tungsten_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.RAW_TUNGSTEN.get());
                        output.accept(ModItems.TUNGSTEN_INGOT.get());
                        output.accept(ModBlocks.TUNGSTEN_ORE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
