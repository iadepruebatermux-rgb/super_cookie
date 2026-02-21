package com.supercookie.mod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class SuperCookieMod implements ModInitializer {
    public static final String MOD_ID = "super_cookie";
    public static final Item SUPER_COOKIE = register(new SuperCookieItem(new Item.Settings().maxCount(64)), "super_cookie");

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> content.add(SUPER_COOKIE));
    }

    private static Item register(Item item, String id) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, id), item);
    }
}