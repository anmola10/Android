package android.support.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface StringDef
{
  public abstract String[] value();
}

/* Location:           C:\Users\T00049862\Downloads\JARS\PersonalDiary-dex2jar.jar
 * Qualified Name:     android.support.annotation.StringDef
 * JD-Core Version:    0.6.2
 */