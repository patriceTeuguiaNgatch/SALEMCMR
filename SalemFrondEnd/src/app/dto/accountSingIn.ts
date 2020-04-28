export class AccountSingInDto {

    private password: string;
    private email: string;

    setPassword(password: string) {
        this.password = password;
    }

    getPassword() {
        return this.password;
    }

    setEmail(email: string) {
        this.email = email;
    }
}