package com.raoulvdberge.refinedstorage.render.model.baked;
/*
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.raoulvdberge.refinedstorage.apiimpl.network.node.cover.Cover;
import com.raoulvdberge.refinedstorage.apiimpl.network.node.cover.CoverType;
import com.raoulvdberge.refinedstorage.item.ItemCover;
import com.raoulvdberge.refinedstorage.util.RenderUtils;
import net.minecraft.block.state.BlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraftforge.common.model.TRSRTransformation;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nullable;
import javax.vecmath.Matrix4f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BakedModelCover extends BakedModelCableCover {
    private class CacheKey {
        private BlockState state;
        private ItemStack stack;
        private Direction side;
        private CoverType type;

        CacheKey(BlockState state, ItemStack stack, Direction side, CoverType type) {
            this.state = state;
            this.stack = stack;
            this.side = side;
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            BakedModelCover.CacheKey cacheKey = (BakedModelCover.CacheKey) o;

            return cacheKey.type == type && cacheKey.stack.getItem() == stack.getItem() && cacheKey.stack.getItemDamage() == stack.getItemDamage() && cacheKey.side == side && Objects.equals(cacheKey.state, state);
        }

        @Override
        public int hashCode() {
            int result = stack.getItem().hashCode();
            result = 31 * result + stack.getItemDamage();
            result = 31 * result + (side != null ? side.hashCode() : 0);
            result = 31 * result + (state != null ? state.hashCode() : 0);
            result = 31 * result + type.hashCode();
            return result;
        }
    }

    private static final LoadingCache<CacheKey, List<BakedQuad>> CACHE = CacheBuilder.newBuilder().build(new CacheLoader<CacheKey, List<BakedQuad>>() {
        @Override
        public List<BakedQuad> load(CacheKey key) {
            List<BakedQuad> quads = new ArrayList<>();

            addCover(quads, new Cover(key.stack, key.type), Direction.NORTH, key.side, 0, null, false);

            return quads;
        }
    });

    @Nullable
    private ItemStack stack;
    private CoverType type;

    public BakedModelCover(@Nullable ItemStack stack, CoverType type) {
        super(null);

        this.stack = stack;
        this.type = type;
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, long rand) {
        if (stack == null) {
            return Collections.emptyList();
        }

        CacheKey key = new CacheKey(state, ItemCover.getItem(stack), side, type);

        return CACHE.getUnchecked(key);
    }

    @Override
    public ItemOverrideList getOverrides() {
        if (stack != null) {
            return ItemOverrideList.NONE;
        }

        return new ItemOverrideList(Collections.emptyList()) {
            @Override
            public IBakedModel handleItemState(IBakedModel originalModel, ItemStack stack, @Nullable World world, @Nullable EntityLivingBase entity) {
                return new BakedModelCover(stack, type);
            }
        };
    }

    @Override
    public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType cameraTransformType) {
        TRSRTransformation transform = RenderUtils.getDefaultBlockTransforms().get(cameraTransformType);

        return Pair.of(this, transform == null ? RenderUtils.EMPTY_MATRIX_TRANSFORM : transform.getMatrix());
    }

    @Override
    public boolean isAmbientOcclusion() {
        return true;
    }

    @Override
    public boolean isGui3d() {
        return true;
    }

    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleTexture() {
        return null;
    }

    @Override
    public boolean isAmbientOcclusion(BlockState state) {
        return true;
    }

    @Override
    @SuppressWarnings("deprecation")
    public ItemCameraTransforms getItemCameraTransforms() {
        return ItemCameraTransforms.DEFAULT;
    }
}*/