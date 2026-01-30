package br.com.leozin.modz.projetomodmine;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModItems {
    // registrar os itens no jogo
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(Projetomodmine.MODID);

    // tungstenio cru
    public static final DeferredHolder<Item, Item> RAW_TUNGSTEN = ITEMS.register("raw_tungsten",
            () -> new Item(new Item.Properties()));

    //barra de tungstenio
    public static final DeferredHolder<Item, Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot",
            () -> new Item(new Item.Properties()));
    // registra tudo na classe principal
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final DeferredHolder<Item, Item> MOISSANITE_SHARD = ITEMS.register("moissanite_shard",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> MOISSANITE = ITEMS.register("moissanite",
            () -> new Item(new Item.Properties()));
}
