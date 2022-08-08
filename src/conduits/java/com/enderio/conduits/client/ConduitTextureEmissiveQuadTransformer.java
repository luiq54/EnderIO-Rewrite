package com.enderio.conduits.client;

import com.enderio.api.conduit.IConduitType;
import com.enderio.core.client.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.client.model.IQuadTransformer;
import net.minecraftforge.client.model.QuadTransformers;

public record ConduitTextureEmissiveQuadTransformer(IConduitType type, boolean isActive) implements IQuadTransformer {

    @Override
    public void processInPlace(BakedQuad quad) {
        int lightLevel = type.getLightLevel(isActive);
        if (lightLevel != 0)
            QuadTransformers.settingEmissivity(type.getLightLevel(isActive)).processInPlace(quad);
        TextureAtlasSprite newSprite = blockAtlas().getSprite(type.getTexture());
        for (int i = 0; i < 4; i++) {
            float[] uv0 = RenderUtil.unpackVertices(quad.getVertices(), i, IQuadTransformer.UV0, 2);
            uv0[0] = (uv0[0] - quad.getSprite().getU0()) * newSprite.getWidth() / quad.getSprite().getWidth() + newSprite.getU0();
            uv0[1] = (uv0[1] - quad.getSprite().getV0()) * newSprite.getHeight() / quad.getSprite().getHeight() + newSprite.getV0();
            int[] packedTextureData = RenderUtil.packUV(uv0[0], uv0[1]);
            quad.getVertices()[4 + i * 8] = packedTextureData[0];
            quad.getVertices()[5 + i * 8] = packedTextureData[1];
        }

    }

    private static TextureAtlas blockAtlas() {
        return Minecraft.getInstance().getModelManager().getAtlas(InventoryMenu.BLOCK_ATLAS);
    }

}
