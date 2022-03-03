package library.commandrunner.add.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@SuppressWarnings("deprecation")
public class AddDataTypeValidator implements ConstraintValidator<AddDataType, CharSequence> {

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        String stringValue = value.toString();
        return AddDataType.VALID_ADD_TYPES.contains(stringValue);

    }
}
