/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { Income } from '../models/Income';
import type { CancelablePromise } from '../core/CancelablePromise';
import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';
export class IncomeControllerService {
    /**
     * @returns Income OK
     * @throws ApiError
     */
    public static getIncomes(): CancelablePromise<Array<Income>> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/incomes/in',
            errors: {
                400: `Bad Request`,
                404: `Not Found`,
                406: `Not Acceptable`,
                500: `Internal Server Error`,
            },
        });
    }
    /**
     * @param requestBody
     * @returns any OK
     * @throws ApiError
     */
    public static putIncome(
        requestBody: Income,
    ): CancelablePromise<any> {
        return __request(OpenAPI, {
            method: 'PUT',
            url: '/incomes/in',
            body: requestBody,
            mediaType: 'application/json',
            errors: {
                400: `Bad Request`,
                404: `Not Found`,
                406: `Not Acceptable`,
                500: `Internal Server Error`,
            },
        });
    }
    /**
     * @param requestBody
     * @returns any OK
     * @throws ApiError
     */
    public static postIncome(
        requestBody: Income,
    ): CancelablePromise<any> {
        return __request(OpenAPI, {
            method: 'POST',
            url: '/incomes/in',
            body: requestBody,
            mediaType: 'application/json',
            errors: {
                400: `Bad Request`,
                404: `Not Found`,
                406: `Not Acceptable`,
                500: `Internal Server Error`,
            },
        });
    }
    /**
     * @param incomeId
     * @returns Income OK
     * @throws ApiError
     */
    public static getIncome(
        incomeId: string,
    ): CancelablePromise<Income> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/incomes/in={incomeId}',
            query: {
                'incomeId': incomeId,
            },
            errors: {
                400: `Bad Request`,
                404: `Not Found`,
                406: `Not Acceptable`,
                500: `Internal Server Error`,
            },
        });
    }
    /**
     * @param incomeId
     * @returns any OK
     * @throws ApiError
     */
    public static removeIncome(
        incomeId: string,
    ): CancelablePromise<any> {
        return __request(OpenAPI, {
            method: 'DELETE',
            url: '/incomes/in={incomeId}',
            query: {
                'incomeId': incomeId,
            },
            errors: {
                400: `Bad Request`,
                404: `Not Found`,
                406: `Not Acceptable`,
                500: `Internal Server Error`,
            },
        });
    }
}
