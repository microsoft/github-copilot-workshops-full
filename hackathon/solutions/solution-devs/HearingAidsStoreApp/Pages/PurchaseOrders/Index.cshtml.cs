using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using iTextSharp.text;
using iTextSharp.text.pdf;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using OfficeOpenXml;
using HearingAidsStoreApp.Models;

namespace HearingAidsStoreApp.Pages.PurchaseOrders
{
    public class IndexModel : PageModel
    {
        private readonly ApplicationDbContext _context;

        public IndexModel(ApplicationDbContext context)
        {
            _context = context;
        }

        public IList<PurchaseOrder> PurchaseOrder { get; set; } = default!;

        public string SearchCustomer { get; set; }
        public DateTime? SearchDate { get; set; }

        public async Task OnGetAsync(string searchCustomer, DateTime? searchDate)
        {
            SearchCustomer = searchCustomer;
            SearchDate = searchDate;

            var orders = _context.PurchaseOrder.Include(p => p.Customer).Include(p => p.Product).AsQueryable();

            if (!string.IsNullOrEmpty(SearchCustomer))
            {
                orders = orders.Where(p => p.Customer.Surname.Contains(SearchCustomer));
            }

            if (SearchDate.HasValue)
            {
                orders = orders.Where(p => p.PurchaseDate.Date == SearchDate.Value.Date);
            }

            PurchaseOrder = await orders.ToListAsync();
        }

        public async Task<IActionResult> OnGetExportToExcel()
        {
            var orders = await _context.PurchaseOrder.Include(x => x.Customer).Include(x => x.Product)
            .Select(p => new
            {
                p.PurchaseDate,
                p.CustomerId,
                CustomerName = p.Customer.FullName,
                Product = p.Product.Name
            }).ToListAsync(); // Fetch your data from the database

            ExcelPackage.LicenseContext = LicenseContext.NonCommercial;
            using (var package = new ExcelPackage())
            {

                var worksheet = package.Workbook.Worksheets.Add("orders");
                worksheet.Cells["A1"].LoadFromCollection(orders, PrintHeaders: true);
                var stream = new MemoryStream();
                package.SaveAs(stream);

                string excelName = $"orders-{DateTime.Now.ToString("yyyyMMddHHmmssfff")}.xlsx";

                return File(stream.ToArray(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", excelName);
            }
        }

        public async Task<IActionResult> OnGetExportToPdf()
        {
            var orders = await _context.PurchaseOrder.Include(x => x.Customer).Include(x => x.Product).ToListAsync(); // Fetch your data from the database

            using (MemoryStream stream = new MemoryStream())
            {
                Document pdfDoc = new Document(PageSize.A4.Rotate(), 10f, 10f, 10f, 0f);
                PdfWriter.GetInstance(pdfDoc, stream);
                pdfDoc.Open();

                PdfPTable table = new PdfPTable(6); // Create a table with 6 columns

                // Add table headers
                table.AddCell("Purchase Date");
                table.AddCell("Name");
                table.AddCell("Surname");
                table.AddCell("Address");
                table.AddCell("Product Name");
                table.AddCell("Product Description");

                foreach (var order in orders)
                {
                    // Add customer data to the table
                    table.AddCell(order.PurchaseDate.ToString("dd/MM/yyyy"));
                    table.AddCell(order.Customer.Name);
                    table.AddCell(order.Customer.Surname);
                    table.AddCell(order.Customer.Address);
                    table.AddCell(order.Product.Name);
                    table.AddCell(order.Product.Description);
                }

                pdfDoc.Add(table); // Add the table to the PDF document

                pdfDoc.Close();

                return File(stream.ToArray(), "application/pdf", "Orders.pdf");
            }
        }
    }
}
