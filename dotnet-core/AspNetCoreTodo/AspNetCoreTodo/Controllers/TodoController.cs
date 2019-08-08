using System.Threading.Tasks;
using AspNetCoreTodo.Services;
using AspNetCoreTodo.Views;
using Microsoft.AspNetCore.Mvc;

namespace AspNetCoreTodo.Controllers
{
    public class TodoController : Controller
    {
        private readonly ITodoItemService _todoItemService;

        public TodoController(ITodoItemService todoItemService)
        {
            _todoItemService = todoItemService;
        }
        public async Task<IActionResult> Index()
        {
            // Get to do items from database
            var items = await _todoItemService.GetIncompleteItemsAsync();

            // Put items into model
            var model = new ToDoViewModel()
            {
                Items = items
            };

            // Render view using the model
            return View(model);
        }
    }
}