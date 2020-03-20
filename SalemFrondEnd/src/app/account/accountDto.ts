export class AccountDto {
    accountId: string;
    firstName: string;
    lastName: string;
    password: string;
    email: string;
    telephoneNumber: string;
    role: string = "volunteer";
}