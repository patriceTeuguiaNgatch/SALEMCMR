import { AccountDto } from './accountDto';
import { ErrorDetailDto } from './errorDetaildto';

export interface ResponseAccountDto {

    httpStatus?: string;
    // data?: AccountDto;
    errorDetail?: ErrorDetailDto;

}
