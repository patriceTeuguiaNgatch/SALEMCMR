import { DonDto } from './donDto';

export class AccountDto {
    accountId: string;
    firstName: string;
    lastName: string;
    password: string;
    email: string;
    phoneNumber: string;
    role: string = "subscriber";
    donList: any = [];
}