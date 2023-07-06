package com.example.trabajitosinc.data

import com.example.trabajitosinc.R
import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.data.models.PortfolioModel
import com.example.trabajitosinc.data.models.PortfolioModel2
import com.example.trabajitosinc.data.models.ReviewsModel
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.data.models.TrabajitoModel
import com.example.trabajitosinc.data.models.UserComplexModel

val categories = mutableListOf(
    CategoryModel("Carpentry", R.drawable.carpentry_icon),
    CategoryModel("Electrician", R.drawable.electrician_icon),
    CategoryModel("Housekeeper", R.drawable.housekeeper_icon),
    CategoryModel("Plumbing", R.drawable.plumbing_icon),
    CategoryModel("Welding", R.drawable.welding_icon),
    CategoryModel("Plumbing", R.drawable.plumbing_icon),
    CategoryModel("Welding", R.drawable.welding_icon),
    CategoryModel("Plumbing", R.drawable.plumbing_icon),
    CategoryModel("Welding", R.drawable.welding_icon)
)
val porfolios = mutableListOf(
    PortfolioModel(
        id = "123",
        title = "",
        description = "hola",
        images =  R.drawable.welding_icon,
        user = "Lee ",
        category = "Futbolista",
        review = listOf(
            ReviewsModel(description = "Excelente", qualification = 10, id_user = "123")
        )

    ),
    PortfolioModel(
            id = "123",
    title = "",
    description = "hola",
    images =  R.drawable.plumbing_icon,
    user = "Lee ",
    category = "Futbolista",
    review = listOf(
        ReviewsModel(description = "Excelente", qualification = 10, id_user = "123")
    )

),
    PortfolioModel(
        id = "123",
        title = "",
        description = "hola",
        images =  R.drawable.housekeeper_icon,
        user = "Lee ",
        category = "Futbolista",
        review = listOf(
        ReviewsModel(description = "Excelente", qualification = 10, id_user = "123")
    )

),
    PortfolioModel(
        id = "123",
        title = "",
        description = "hola",
        images =  R.drawable.no_image,
        user = "Lee ",
        category = "Futbolista",
        review = listOf(
            ReviewsModel(description = "Excelente", qualification = 10, id_user = "123")
        )

    )
)

val trabajitos = mutableListOf(
    TrabajitoModel(
        workerId = "W001",
        requesterId = "R001",
        workerName = "Alice Johnson",
        workerCategory = "Carpenter",
        workerLocation = "New York, USA",
        phone = "+1 123-456-7890",
        startDate = "2023-06-01",
        endDate = "2023-06-10",
        taskDescription = "Perform data entry and analysis",
        bill = "$500.00",
        TrabajitoStatus = "Completed"
    ),
    TrabajitoModel(
        workerId = "W002",
        requesterId = "R002",
        workerName = "Bob Smith",
        workerCategory = "Carpenter",
        workerLocation = "Los Angeles, USA",
        phone = "+1 987-654-3210",
        startDate = "2023-06-05",
        endDate = "2023-06-15",
        taskDescription = "Design website layout",
        bill = "$800.00",
        TrabajitoStatus = "In Progress"
    ),
    TrabajitoModel(
        workerId = "W003",
        requesterId = "R003",
        workerName = "Emma Davis",
        workerCategory = "Carpenter",
        workerLocation = "London, UK",
        phone = "+44 1234-567890",
        startDate = "2023-06-10",
        endDate = "2023-06-20",
        taskDescription = "Write marketing copy",
        bill = "$600.00",
        TrabajitoStatus = "Pending"
    )

)

val users = mutableListOf(
    UserModel("1","Jose","Nestor@uca.com",25252525,"Uca", R.drawable.plumbing_icon) ,
    UserModel("2","Jose","Nestor@uca.com",25252525,"Uca", R.drawable.electrician_icon) ,
    UserModel("3","Jose","Nestor@uca.com",25252525,"Uca", R.drawable.housekeeper_icon),
    UserModel("4","Jose","Nestor@uca.com",25252525,"Uca", R.drawable.welding_icon)
)

val complexUsers = mutableListOf(
    UserComplexModel(
        id = "1",
        name = "John Carpenter",
        email = "johncarpenter@example.com",
        number = 1234567890,
        location = "New York",
        image = R.drawable.no_image,
        portfolio = PortfolioModel2(
            images = arrayOf(
                "https://t3.ftcdn.net/jpg/00/89/10/68/360_F_89106812_D8J6Y7KzgLr1FKTgOYZKYSM458BXTCaX.jpg",
                "https://uploads-ssl.webflow.com/647888ca92d03e3fca3f1ea0/647888ca92d03e3fca3f2389_carpentry-p-1080.jpeg"
            ),
            title = "Custom Furniture",
            category = "Carpentry",
            description = "Specializing in crafting custom furniture pieces with high-quality materials."
        )
    ),
    UserComplexModel(
        id = "2",
        name = "Emily Woodworker",
        email = "emilywoodworker@example.com",
        number = 987654321,
        location = "Los Angeles",
        image = R.drawable.no_image,
        portfolio = PortfolioModel2(
            images = arrayOf(
                "https://example.com/carpentry_image3.jpg",
                "https://example.com/carpentry_image4.jpg"
            ),
            title = "Cabinetry and Shelving",
            category = "Carpentry",
            description = "Expertise in designing and installing custom cabinetry and shelving solutions."
        )
    ),
    UserComplexModel(
        id = "3",
        name = "David Spark",
        email = "davidspark@example.com",
        number = 234578901,
        location = "Chicago",
        image = R.drawable.no_image,
        portfolio = PortfolioModel2(
            images = arrayOf(
                "https://example.com/electrician_image1.jpg",
                "https://example.com/electrician_image2.jpg"
            ),
            title = "Residential Wiring",
            category = "Electrician",
            description = "Proficient in handling residential wiring projects, ensuring safety and compliance."
        )
    ),
    UserComplexModel(
        id = "4",
        name = "Sophia Electrica",
        email = "sophiaelectrica@example.com",
        number = 345678912,
        location = "Miami",
        image = R.drawable.google_icon,
        portfolio = PortfolioModel2(
            images = arrayOf(
                "https://example.com/electrician_image3.jpg",
                "https://example.com/electrician_image4.jpg"
            ),
            title = "Lighting Installation",
            category = "Electrician",
            description = "Specializing in efficient lighting installation and energy-saving solutions."
        )
    )
)