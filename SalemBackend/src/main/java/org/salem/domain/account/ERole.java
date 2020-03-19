package org.salem.domain.account;

public enum ERole {
    ROLE_SUBSCRIBER {
        public String toString() {
            return "subscriber";
        }
    },
    ROLE_MODERATOR {
        public String toString() {
            return "moderator";
        }
    },
    ROLE_ADMINISTRATOR {
        public String toString() {
            return "administrator";
        }
    }
}
