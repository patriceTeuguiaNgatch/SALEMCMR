import { AccountDto } from './accountDto';
import { ErrorDetailDto } from './ErrorDetaildto';

export interface ResponseAccountDto {

    httpStatus?: string;
    // data?: AccountDto;
    errorDetail?: ErrorDetailDto;

}
