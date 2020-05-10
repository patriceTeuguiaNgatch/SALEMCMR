export class DonFinancialRegistrationDto {
    private firstName: string;
    private lastName: string;
    private email: string;
    private token;
    private value: string;
    private currency: string;
    private phoneNumber: string;
    private kind: string;
    private comment: string
    private isConfidential: boolean;
    private edon = "financial";

    setFirstName(firstName: string) {
        this.firstName = firstName;
    }

    setLastName(lasttName: string) {
        this.lastName = lasttName;
    }

    setEmail(email: string) {
        this.email = email;
    }

    getEmail() {
        return this.email;
    }

    setToken(token: string) {
        this.token = token;
    }

    setValue(value: string) {
        this.value = value;
    }

    setCurrency(currency: string) {
        this.currency = currency;
    }

    setkind(kind: string) {
        this.kind = kind;
    }

    setEdon(edon: string) {
        this.edon = edon;
    }

    setComment(comment: string) {
        this.comment = comment;
    }
    setIsConfidential(isConfidential: boolean) {
        this.isConfidential = isConfidential;
    }

    setPhoneNumber(phoneNumber: string) {
        this.phoneNumber = phoneNumber;
    }

}