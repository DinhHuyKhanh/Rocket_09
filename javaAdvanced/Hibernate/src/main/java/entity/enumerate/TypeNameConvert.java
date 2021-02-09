package entity.enumerate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter

public class TypeNameConvert implements AttributeConverter<TypeName,String> {


    public String convertToDatabaseColumn(TypeName name) {
        if(name == null){
            return  null;
        }
        return name.getValue();
    }

    public TypeName convertToEntityAttribute(String value) {
        return TypeName.of(value);
    }
}
