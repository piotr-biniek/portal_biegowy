/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.biniek.web.services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 * przerobiony converter wykożystano projekt ze strony
 * https://www.javacodegeeks.com/2015/06/utilizing-the-java-8-date-time-api-with-jsf-and-java-ee-7.html
 * użycie przez converter="nazwaKonwertera"
 *
 * @author Juneau
 */
@FacesConverter(value = "localDateConverter")
public class LocalDateConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return LocalDate.parse(value);

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Date) {

            Date dateValue = (Date) value;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.format(value);
            return sdf.format(value);
       
        } else {
            LocalDate dateValue = (LocalDate) value;
            return dateValue.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

    }

}
