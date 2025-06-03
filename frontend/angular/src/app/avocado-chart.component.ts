import { Component, Input, OnChanges, ElementRef, ViewChild, AfterViewInit } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
    selector: 'app-avocado-chart',
    standalone: true,
    imports: [CommonModule],
    template: `
    <div style="display: block; width: 100%; max-width: 600px; margin: 2em auto;">
      <canvas #canvas width="600" height="300" style="width:100%;max-width:600px;"></canvas>
    </div>
  `
})
export class AvocadoChartComponent implements OnChanges, AfterViewInit {
    @Input() data: { country: string; price: number }[] = [];
    @ViewChild('canvas', { static: true }) canvasRef!: ElementRef<HTMLCanvasElement>;

    ngAfterViewInit() {
        this.drawChart();
    }

    ngOnChanges() {
        this.drawChart();
    }

    drawChart() {
        if (!this.canvasRef) return;
        const canvas = this.canvasRef.nativeElement;
        const ctx = canvas.getContext('2d');
        if (!ctx) return;
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        if (!this.data || this.data.length === 0) return;

        // Chart dimensions
        const padding = 40;
        const barWidth = 40;
        const gap = 30;
        const maxBarHeight = canvas.height - 2 * padding;
        const maxPrice = Math.max(...this.data.map(d => d.price));

        // Draw axes
        ctx.strokeStyle = '#333';
        ctx.beginPath();
        ctx.moveTo(padding, padding);
        ctx.lineTo(padding, canvas.height - padding);
        ctx.lineTo(canvas.width - padding, canvas.height - padding);
        ctx.stroke();

        // Draw bars
        this.data.forEach((d, i) => {
            const x = padding + gap + i * (barWidth + gap);
            const barHeight = (d.price / maxPrice) * maxBarHeight;
            const y = canvas.height - padding - barHeight;
            ctx.fillStyle = '#4caf50';
            ctx.fillRect(x, y, barWidth, barHeight);
            // Draw country label
            ctx.save();
            ctx.translate(x + barWidth / 2, canvas.height - padding + 15);
            ctx.rotate(-Math.PI / 6);
            ctx.textAlign = 'center';
            ctx.fillStyle = '#222';
            ctx.font = '14px sans-serif';
            ctx.fillText(d.country, 0, 0);
            ctx.restore();
            // Draw price label
            ctx.fillStyle = '#222';
            ctx.font = 'bold 14px sans-serif';
            ctx.textAlign = 'center';
            ctx.fillText(d.price.toFixed(2), x + barWidth / 2, y - 5);
        });
        // Draw axis labels
        ctx.save();
        ctx.font = 'bold 16px sans-serif';
        ctx.fillStyle = '#222';
        ctx.textAlign = 'center';
        ctx.fillText('Country', canvas.width / 2, canvas.height - 5);
        ctx.rotate(-Math.PI / 2);
        ctx.fillText('Price (USD)', -canvas.height / 2, 20);
        ctx.restore();
    }
}
