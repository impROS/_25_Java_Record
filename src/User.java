public record User(long id, String email, String password) {
    public User {
        // Validate email
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email is not valid");
        }

        // Validate password
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password is too short");
        }
    }
}
