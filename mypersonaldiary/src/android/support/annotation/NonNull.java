package android.support.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.FIELD})
public @interface NonNull
{
}

/* Location:           C:\Users\T00049862\Downloads\JARS\PersonalDiary-dex2jar.jar
 * Qualified Name:     android.support.annotation.NonNull
 * JD-Core Version:    0.6.2
 */