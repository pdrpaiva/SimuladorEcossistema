package pt.isec.pa.javalife.model.command.commands;

import pt.isec.pa.javalife.model.command.CommandAdapter;
import pt.isec.pa.javalife.model.command.ICommand;
import pt.isec.pa.javalife.model.data.ecosystem.EcossistemaManager;
import pt.isec.pa.javalife.model.data.elements.IElemento;

public class EditElementoCmd implements ICommand {
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
        manager.removerElemento(original.getId());
        manager.adicionarElemento(updated);
    }

    @Override
    public void undo() {
        manager.removerElemento(updated.getId());
        manager.adicionarElemento(original);
    }


}