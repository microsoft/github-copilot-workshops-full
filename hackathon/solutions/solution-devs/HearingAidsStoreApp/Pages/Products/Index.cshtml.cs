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

namespace HearingAidsStoreApp.Pages.Products
{
    public class IndexModel : PageModel
    {
        private readonly ApplicationDbContext _context;

        public IndexModel(ApplicationDbContext context)
        {
            _context = context;
        }

        public IList<Product> Product { get; set; } = default!;

        public async Task OnGetAsync()
        {
            Product = await _context.Products.ToListAsync();
        }

        public async Task<IActionResult> OnGetExportToExcel()
        {
            var products = await _context.Products.ToListAsync(); // Fetch your data from the database

            ExcelPackage.LicenseContext = LicenseContext.NonCommercial;
            using (var package = new ExcelPackage())
            {
                
                var worksheet = package.Workbook.Worksheets.Add("Products");
                worksheet.Cells["A1"].LoadFromCollection(products, PrintHeaders: true);
                var stream = new MemoryStream();
                package.SaveAs(stream);

                string excelName = $"Products-{DateTime.Now.ToString("yyyyMMddHHmmssfff")}.xlsx";

                return File(stream.ToArray(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", excelName);
            }
        }

        public async Task<IActionResult> OnGetExportToPdf()
        {
            var products = await _context.Products.ToListAsync(); // Fetch your data from the database

            using (MemoryStream stream = new MemoryStream())
            {
                Document pdfDoc = new Document(PageSize.A4, 10f, 10f, 10f, 0f);
                PdfWriter.GetInstance(pdfDoc, stream);
                pdfDoc.Open();

                PdfPTable table = new PdfPTable(3); // Create a table with 3 columns

                // Add table headers
                table.AddCell("Name");
                table.AddCell("Description");
                table.AddCell("Price");

                foreach (var product in products)
                {
                    // Add product data to the table
                    table.AddCell(product.Name);
                    table.AddCell(product.Description);
                    table.AddCell(product.Price.ToString());
                }

                pdfDoc.Add(table); // Add the table to the PDF document

                pdfDoc.Close();

                return File(stream.ToArray(), "application/pdf", "Products.pdf");
            }
        }


    }
}
