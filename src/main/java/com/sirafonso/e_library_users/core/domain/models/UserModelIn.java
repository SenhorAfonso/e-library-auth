package com.sirafonso.e_library_users.core.domain.models;

public record UserModelIn(
        String name,
        String username,
        String email,
        String password
) {
    public static class Builder {
        private String name;
        private String username;
        private String email;
        private String password;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public UserModelIn build() {
            return new UserModelIn(
                    this.name,
                    this.username,
                    this.email,
                    this.password
            );
        }
    }

    public static Builder build() {
        return new Builder();
    }
}
