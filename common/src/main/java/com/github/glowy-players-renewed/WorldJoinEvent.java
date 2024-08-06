



public class WorldJoinEvent {
    private static final Logger logger = getLogger("event");

    public static void onSpawn(ServerWorld world, Entity entity) {
        if (world.isClient()) return;
        if (!(entity instanceof final PlayerEntity player)) return;

        logger.debug("Applying glowing effect to player " + player.getDisplayName());
        player.setGlowing(true);
    }
}