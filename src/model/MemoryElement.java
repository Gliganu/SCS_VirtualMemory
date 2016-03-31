package model;

import view.MemoryElementView;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public abstract  class MemoryElement {

    protected String description;
    protected MemoryElementView memoryElementView;

    public MemoryElement(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MemoryElementView getMemoryElementView() {
        return memoryElementView;
    }

    public void setMemoryElementView(MemoryElementView memoryElementView) {
        this.memoryElementView = memoryElementView;
    }
}
