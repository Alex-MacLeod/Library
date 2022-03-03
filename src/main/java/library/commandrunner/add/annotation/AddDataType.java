package library.commandrunner.add.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;

/**
 * <p>Denotes data types which are valid inputs for the Add command.</p>
 *
 * <p>Valid types for Add command are: "item", "customer"</p>
 *
 * @see AddDataTypeValidator
 *
 * @deprecated since always, this exists solely to play around with annotations as preparation for the OCP Java 11 Exam
 *
 * @author Alex MacLeod
 * @since 03/03/2022
 */
@Target({ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Deprecated(since="always")
@Constraint(
        validatedBy = {}
)
public @interface AddDataType {

    Set<String> VALID_ADD_TYPES = Set.of("item", "customer");

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
