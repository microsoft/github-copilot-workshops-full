import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';

export interface AvocadoPrice {
    country: string;
    price: number;
}

@Injectable({ providedIn: 'root' })
export class AvocadoPriceService {
    private csvUrl = 'assets/avocado-prices.csv';

    constructor(private http: HttpClient) { }

    getPrices(): Observable<AvocadoPrice[]> {
        return this.http.get(this.csvUrl, { responseType: 'text' }).pipe(
            map(csv => this.parseCsv(csv))
        );
    }

    private parseCsv(csv: string): AvocadoPrice[] {
        const lines = csv.trim().split('\n');
        const result: AvocadoPrice[] = [];
        for (let i = 1; i < lines.length; i++) {
            const [country, price] = lines[i].split(',');
            result.push({ country, price: parseFloat(price) });
        }
        return result;
    }
}
