import { Component, OnInit } from '@angular/core';
import { AvocadoPriceService, AvocadoPrice } from './avocado-price.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AvocadoChartComponent } from './avocado-chart.component';
import { InputTextModule } from 'primeng/inputtext';
import { CardModule } from 'primeng/card';
import { ToolbarModule } from 'primeng/toolbar';
import { TableModule } from 'primeng/table';
import { ProgressSpinnerModule } from 'primeng/progressspinner';
import { MessageModule } from 'primeng/message';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule, FormsModule, AvocadoChartComponent,
    InputTextModule, CardModule, ToolbarModule, TableModule, ProgressSpinnerModule, MessageModule, ButtonModule
  ],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class AppComponent implements OnInit {
  protected title = 'avocado-prices';
  prices: AvocadoPrice[] = [];
  loading = true;
  error = '';
  countryFilter: string = '';
  priceFilter: string = '';

  constructor(private priceService: AvocadoPriceService) { }

  ngOnInit() {
    this.priceService.getPrices().subscribe({
      next: (data: AvocadoPrice[]) => {
        this.prices = data;
        this.loading = false;
      },
      error: (err: any) => {
        this.error = 'Failed to load CSV data.';
        this.loading = false;
      }
    });
  }

  filteredPrices(): AvocadoPrice[] {
    return this.prices.filter(price => {
      const countryMatch = !this.countryFilter || price.country.toLowerCase().includes(this.countryFilter.toLowerCase());
      const priceMatch = !this.priceFilter || price.price.toFixed(2).includes(this.priceFilter);
      return countryMatch && priceMatch;
    });
  }
}
