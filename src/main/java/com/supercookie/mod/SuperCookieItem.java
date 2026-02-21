package com.supercookie.mod;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SuperCookieItem extends Item {
    public SuperCookieItem(Item.Settings settings) {
        super(settings.food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).build()));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, PlayerEntity user) {
        if (!world.isClient) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1200, 9, false, true));
        }
        return super.finishUsing(stack, world, user);
    }
}