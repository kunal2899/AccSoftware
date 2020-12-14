import { HttpHeaders } from '@angular/common/http'

export const APP_URL = "http://localhost:8080"
export const CORS_HEADERS = {
    headers : new HttpHeaders({
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Methods': 'GET,POST,OPTIONS,DELETE,PUT'
    })
}