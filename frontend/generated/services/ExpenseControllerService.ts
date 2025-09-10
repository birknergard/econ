/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { Expense } from '../models/Expense';
import type { ExpenseList } from '../models/ExpenseList';
import type { CancelablePromise } from '../core/CancelablePromise';
import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';
export class ExpenseControllerService {
    /**
     * @returns Expense OK
     * @throws ApiError
     */
    public static getExpenses(): CancelablePromise<Array<Expense>> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/expenses/ex',
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
    public static putExpense(
        requestBody: Expense,
    ): CancelablePromise<any> {
        return __request(OpenAPI, {
            method: 'PUT',
            url: '/expenses/ex',
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
    public static postExpense(
        requestBody: Expense,
    ): CancelablePromise<any> {
        return __request(OpenAPI, {
            method: 'POST',
            url: '/expenses/ex',
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
     * @param expenseId
     * @returns Expense OK
     * @throws ApiError
     */
    public static getExpense(
        expenseId: string,
    ): CancelablePromise<Expense> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/expenses/ex={expenseId}',
            query: {
                'expenseId': expenseId,
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
     * @param expenseId
     * @returns any OK
     * @throws ApiError
     */
    public static removeExpense(
        expenseId: string,
    ): CancelablePromise<any> {
        return __request(OpenAPI, {
            method: 'DELETE',
            url: '/expenses/ex={expenseId}',
            query: {
                'expenseId': expenseId,
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
     * @returns ExpenseList OK
     * @throws ApiError
     */
    public static getExpensesByCategory(): CancelablePromise<ExpenseList> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/expenses/ex/category',
            errors: {
                400: `Bad Request`,
                404: `Not Found`,
                406: `Not Acceptable`,
                500: `Internal Server Error`,
            },
        });
    }
}
