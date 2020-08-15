package com.thecodemonkey.buildinggadgets.common.building.view;

import jdk.internal.jline.internal.Nullable;
import jdk.nashorn.internal.ir.annotations.Immutable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Objects;

@Immutable
public final class BuildContext {

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builderOf(@Nullable BuildContext context) {
        Builder builder = builder();
        if (context == null) {
            return builder;
        }

        return builder.world(context.getWorld()).player(context.getPlayer()).stack(context.getStack());
    }

    private final World world;
    private final PlayerEntity player;
    private final ItemStack stack;

    public BuildContext(World world, PlayerEntity player, ItemStack stack) {
        this.world = world;
        this.player = player;
        this.stack = stack;
    }

    public World getWorld() {
        return world;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public ItemStack getStack() {
        return stack;
    }

    public static final class Builder {
        private World world;
        private PlayerEntity buildingPlayer;
        private ItemStack stack;

        public Builder world(World world) {
            this.world = world;
            return this;
        }

        public Builder player(PlayerEntity buildingPlayer) {
            this.buildingPlayer = buildingPlayer;
            if (world == null && buildingPlayer != null)
                this.world = buildingPlayer.world;
            return this;
        }

        public Builder stack(ItemStack stack) {
            this.stack = stack;
            return this;
        }

        public BuildContext build() {
            return build(null);
        }

        public BuildContext build(World world) {
            return new BuildContext(world != null ? world : Objects.requireNonNull(this.world), buildingPlayer, stack);
        }
    }
}
