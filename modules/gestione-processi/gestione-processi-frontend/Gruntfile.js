module.exports = function(grunt) {

  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    clean: ['dist', 'modules/gestione-processi/gestione-processi-frontend/src/main/resources/META-INF/resources/libs'],
    concat: {
      options: {
        separator: ';'
      },
      dist: {
        src: [
              'alpaca/customfields/**/*.js',
              '!alpaca/customfields/**/_*.js',
              '!alpaca/customfields/**/_*.txt',
        ],
        dest: 'alpaca/dist/custom-fields.js'
      }
    },
    copy: {
		libs: {
			files: [
				{
					expand: true,
					cwd: 'node_modules/bpmn-js/lib',
					src: '**/*',
					dest: 'modules/gestione-processi/gestione-processi-frontend/src/main/resources/META-INF/resources/libs/bpmn-js'
				},
				{
					expand: true,
					cwd: 'node_modules/bpmn-js-properties-panel/lib',
					src: '**/*',
					dest: 'modules/gestione-processi/gestione-processi-frontend/src/main/resources/META-INF/resources/libs/bpmn-js-properties-panel'
				},
				{
					expand: true,
					cwd: 'node_modules/bpmn-moddle/lib',
					src: '**/*',
					dest: 'modules/gestione-processi/gestione-processi-frontend/src/main/resources/META-INF/resources/libs/bpmn-moddle'
				},
				{
					expand: true,
					cwd: 'node_modules/diagram-js/lib',
					src: '**/*',
					dest: 'modules/gestione-processi/gestione-processi-frontend/src/main/resources/META-INF/resources/libs/diagram-js'
				}
			]
		}
	},
    uglify: {
      options: {
        banner: '/*! <%= pkg.name %> <%= grunt.template.today("dd-mm-yyyy HH:MM:ss") %> */\n'
      },
      dist: {
        files: {
          'alpaca/dist/custom-fields.min.js': ['<%= concat.dist.dest %>']
        }
      }
    },
    jshint: {
      files: ['Gruntfile.js', 'alpaca/customfields/**/*.js'],
      options: {
        // options here to override JSHint defaults
      }
    },
    watch: {
      files: ['<%= jshint.files %>'],
      tasks: ['jshint']
    }
  });

  grunt.file.setBase('../../../');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-clean');
  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.loadNpmTasks('grunt-replace');

  grunt.registerTask('test', ['jshint']);

  grunt.registerTask('default', [/*'jshint', */'clean', 'concat', 'copy', 'uglify']);
};