// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

public abstract class Task implements ITask
{
    // Data members.
    private String name;
    private boolean enabled;

    // Ctor.
    public Task(String name, boolean enabled)
    {
        this.name = name;
        this.enabled = enabled;
    }

    // Accessors.
    public String getName()
    {
        return name;
    }

    public boolean isEnabled()
    {
        return enabled;
    }
}
