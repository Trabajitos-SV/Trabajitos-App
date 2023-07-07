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
        images = listOf(
            "https://phantom-marca.unidadeditorial.es/936fd16b77c008bf1039febccb975c52/resize/828/f/jpg/assets/multimedia/imagenes/2023/05/09/16836175499566.jpg",
            "https://static01.nyt.com/images/2023/04/20/fashion/20HASBULLA/20HASBULLA-videoSixteenByNineJumbo1600.jpg",
            "data:image/jpeg;base64,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",
        ),

        user = "Lee ",
        category = "Futbolista",
        review = listOf(
            ReviewsModel(description = "Excelente", qualification = 10, id_user = "123")
        )

    ),
    /*PortfolioModel(
        id = "123",
        title = "",
        description = "hola",
        images =  "https://static01.nyt.com/images/2023/04/20/fashion/20HASBULLA/20HASBULLA-videoSixteenByNineJumbo1600.jpg",
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
        images =  "data:image/jpeg;base64,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",
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
        images =  "https://ak.uecdn.es/p/108/thumbnail/entry_id/0_3c4ynsbq/width/660/cache_st/1683708396/type/2/bgcolor/000000/0_3c4ynsbq.jpg",
        user = "Lee ",
        category = "Futbolista",
        review = listOf(
            ReviewsModel(description = "Excelente", qualification = 10, id_user = "123")
        )

    )

     */
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