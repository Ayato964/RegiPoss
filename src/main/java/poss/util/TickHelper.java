package poss.util;

public interface TickHelper {
    public abstract <T extends IsTick> void tick( T entity);
}
