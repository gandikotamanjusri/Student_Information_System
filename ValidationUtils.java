class ValidationUtils {

    public static boolean isValidAge(int age) {
        return age > 0;
    }

    public static boolean isValidGrade(String grade) {
        return grade.matches("[A-F]");
    }

    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
