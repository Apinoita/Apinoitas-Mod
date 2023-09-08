package net.apinoita.apinoitasmod.block.custom;

import net.apinoita.apinoitasmod.sound.ModSounds;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

import javax.naming.Context;
import java.util.Timer;

public class C4Block extends FacingBlock {

    public static final DirectionProperty FACING = Properties.FACING;

    public static final BooleanProperty LIT = BooleanProperty.of("lit");

    private ServerWorld world;
    private Position pos;

    public C4Block(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient() && hand == Hand.MAIN_HAND ) {
            world.setBlockState(pos, state.cycle(LIT));
            world.createExplosion(null, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), 4, false, Explosion.DestructionType.DESTROY);
            world.playSound(null, pos, ModSounds.C4_BEEP, SoundCategory.BLOCKS, 1f,1f);
        }
        return ActionResult.SUCCESS;

    }

    private static VoxelShape SHAPE = Block.createCuboidShape(4, 0, 3, 12, 2, 13);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT);
    }
}
