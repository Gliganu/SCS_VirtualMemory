package model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by GligaBogdan on 02-Apr-16.
 */
public class Command {

    private CommandType commandType;
    private MemoryElement memoryElement;
    private boolean visible;

    private String addressBlockDescription;
    private AddressBlock addressBlock;

    private List<Command> innerCommands = new ArrayList<>();


    public Command(CommandType commandType) {
        this.commandType = commandType;
    }

    public Command(CommandType commandType, MemoryElement memoryElement, boolean visible) {
        this.commandType = commandType;
        this.memoryElement = memoryElement;
        this.visible = visible;
    }

    public Command(CommandType commandType, AddressBlock addressBlock, String addressBlockDescription) {
        this.commandType = commandType;
        this.addressBlockDescription = addressBlockDescription;
        this.addressBlock = addressBlock;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public MemoryElement getMemoryElement() {
        return memoryElement;
    }

    public void setMemoryElement(MemoryElement memoryElement) {
        this.memoryElement = memoryElement;
    }

    public void changeMemoryElementVisibility() {
        memoryElement.setVisible(visible);
    }

    public List<Command> getInnerCommands() {
        return innerCommands;
    }

    public void setInnerCommands(List<Command> innerCommands) {
        this.innerCommands = innerCommands;
    }

    public void addInnerCommand(Command command) {
        innerCommands.add(command);
    }

    public String getAddressBlockDescription() {
        return addressBlockDescription;
    }

    public void setAddressBlockDescription(String addressBlockDescription) {
        this.addressBlockDescription = addressBlockDescription;
    }

    public AddressBlock getAddressBlock() {
        return addressBlock;
    }

    public void setAddressBlock(AddressBlock addressBlock) {
        this.addressBlock = addressBlock;
    }

    public void changeAddressBlockDescription() {
        addressBlock.setInDescription(addressBlockDescription);
    }


    public enum CommandType {

        ELEMENT_VISIBILITY, NEXT_STORY, ADDRESS_BLOCK_WRITE

    }

}
