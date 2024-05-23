package pt.isec.pa.javalife.model.command.commands;

import pt.isec.pa.javalife.model.command.CommandAdapter;
import pt.isec.pa.javalife.model.data.ecosystem.EcossistemaManager;
import pt.isec.pa.javalife.model.data.elements.IElemento;

public class EditElementoCmd extends CommandAdapter {
    private final EcossistemaManager manager;
    private final IElemento original;
    private final IElemento updated;

    public EditElementoCmd(EcossistemaManager manager, IElemento original, IElemento updated) {
        this.manager = manager;
        this.original = original;
        this.updated = updated;
    }

    @Override
    public void execute() {
        manager.removeElemento(original.getId());
        manager.addElemento(updated);
    }

    @Override
    public void undo() {
        manager.removeElemento(updated.getId());
        manager.addElemento(original);
    }


}