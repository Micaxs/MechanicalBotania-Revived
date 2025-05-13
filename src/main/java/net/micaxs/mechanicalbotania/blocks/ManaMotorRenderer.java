package net.micaxs.mechanicalbotania.blocks;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.render.CachedBuffers;
import net.createmod.catnip.render.SuperByteBuffer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;

public class ManaMotorRenderer extends KineticBlockEntityRenderer<ManaMotorBlockEntity> {
    public ManaMotorRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }


    @Override
    protected void renderSafe(ManaMotorBlockEntity be, float partialTicks, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        super.renderSafe(be, partialTicks, ms, buffer, light, overlay);

        // Try to get facing from block state if available
        BlockState state = be.getBlockState();
        Direction facing;

        if (state.hasProperty(BlockStateProperties.FACING)) {
            facing = state.getValue(BlockStateProperties.FACING);
        } else if (state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
            facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
        } else {
            facing = Direction.EAST;
        }

        // Get axis from the facing direction
        Direction.Axis axis = facing.getAxis();

        // Get half shaft model
        SuperByteBuffer halfShaftBuffer = CachedBuffers.partialFacing(AllPartialModels.SHAFT_HALF, be.getBlockState(), facing);

        // Calculate rotation angle - use same formula for all directions
        float time = AnimationTickHolder.getRenderTime(be.getLevel());
        float speed = be.getGeneratedSpeed();
        float baseAngle = ((((time * speed * 3f / 10) % 360 / 180)) * (float) Math.PI);

        // Adjust the shaft appearance to fix misalignment issue?
        switch (facing) {
            case DOWN:
            case NORTH:
            case SOUTH:
            case UP:
                // For whatever reason, 89.93f is the magical alignment number for some unknown specific reason,
                // it shall be known as the "magic alignment number".
                float magicAlignmentNumber = 89.93f;
                halfShaftBuffer.rotateCentered((((((time * speed * 3f / 10) % 360 / 180)) * (float) Math.PI) + magicAlignmentNumber), axis);
                break;
            default:
                halfShaftBuffer.rotateCentered(baseAngle, axis);
                break;
        }

        // Render the half shaft
        halfShaftBuffer.light(light).renderInto(ms, buffer.getBuffer(RenderType.solid()));
    }

    @Override
    protected SuperByteBuffer getRotatedModel(ManaMotorBlockEntity be, BlockState state) {
        return super.getRotatedModel(be, state);
    }


}
