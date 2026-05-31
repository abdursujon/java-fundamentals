package abstraction;

/**
 * Abstraction is hiding implementation details and exposing only essential operations.
 */
abstract class TV {
    abstract void turnOn();
    abstract void turnOf();
    abstract void increaseVolume();
    abstract void decreaseVolume();
}