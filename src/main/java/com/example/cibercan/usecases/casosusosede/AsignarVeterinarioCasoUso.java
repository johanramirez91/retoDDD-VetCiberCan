package com.example.cibercan.usecases.casosusosede;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.cibercan.domain.sede.Sede;
import com.example.cibercan.domain.sede.command.AsignarVeterinario;

public class AsignarVeterinarioCasoUso extends UseCase<RequestCommand<AsignarVeterinario>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarVeterinario> asignarVeterinarioRequestCommand) {
        var command = asignarVeterinarioRequestCommand.getCommand();
        var veterinario = Sede.from(command.getSedeId(), retrieveEvents(command.getSedeId().value()));
        veterinario.asignarVeterinario(command.getVeterinarioId(), command.getNombre(), command.getEmail(), command.getTelefono());
        emit().onResponse(new ResponseEvents(veterinario.getUncommittedChanges()));
    }
}
