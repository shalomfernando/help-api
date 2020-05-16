package com.example.helpapi.Domain.Commands.CustomerCommands.Inputs;

import com.example.helpapi.Domain.Config.Notifications;
import com.example.helpapi.Domain.Config.ValidationContract;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Calendar;

@EqualsAndHashCode(callSuper = true)
@Data
public class SaveCustomerCommand  extends Notifications {

    public String Name;
    public String Cpf;
    public String Email;
    public String Password;
    public Calendar Birthday;
    public boolean IsValid() {
        AddNotification(ValidationContract.IsNullOrEmpty(Name,"Nome","Não pode ser nulo ou vazio."));
        AddNotification(ValidationContract.MaxLenght(Cpf,11,"Cpf","O tamanho é maior do que o permitido."));
        return Valid();
    }

}
