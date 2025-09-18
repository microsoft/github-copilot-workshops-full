using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.AspNetCore.Mvc.Rendering;
using HearingAidsStoreApp.Models;

namespace HearingAidsStoreApp.Pages.PurchaseOrders
{
    public class CreateModel : PageModel
    {
        private readonly ApplicationDbContext _context;

        public CreateModel(ApplicationDbContext context)
        {
            _context = context;
        }

        public IActionResult OnGet()
        {
            ViewData["CustomerId"] = new SelectList(_context.Customer, "ID", "FullName");
            ViewData["ProductId"] = new SelectList(_context.Products, "ID", "Name");
            return Page();
        }

        [BindProperty]
        public PurchaseOrder PurchaseOrder { get; set; } = default!;

        // To protect from overposting attacks, see https://aka.ms/RazorPagesCRUD
        public async Task<IActionResult> OnPostAsync()
        {
            if (!ModelState.IsValid)
            {
                return Page();
            }

            _context.PurchaseOrder.Add(PurchaseOrder);
            await _context.SaveChangesAsync();

            return RedirectToPage("./Index");
        }
    }
}
