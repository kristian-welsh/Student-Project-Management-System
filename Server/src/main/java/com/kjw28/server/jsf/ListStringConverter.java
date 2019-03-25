package com.kjw28.server.jsf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "listStringConverter")
public class ListStringConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        if(value.length() == 0)
            return new ArrayList<String>();
        return Arrays.asList(value.split(","));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        List<String> list = (List<String>)value;
        String asString = list.toString();
        return asString.substring(1, asString.length() - 1);
    }
}

